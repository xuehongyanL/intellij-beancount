package space.wanderful.intellij.plugin.beancount.features.formatter;

import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.CURRENCY;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.DATE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.EXPR;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.META_KEY;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.META_KV_DELIMITER;

import java.util.concurrent.TimeUnit;

import com.intellij.formatting.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Stopwatch;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import space.wanderful.intellij.plugin.beancount.BeancountLanguage;
import space.wanderful.intellij.plugin.beancount.features.completion.AccountsCompleter;
import space.wanderful.intellij.plugin.beancount.psi.BeancountAmount;
import space.wanderful.intellij.plugin.beancount.psi.BeancountExpr;
import space.wanderful.intellij.plugin.beancount.psi.BeancountFile;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTreeUtil;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTypeUtil;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTypes;

public class BeancountFormattingModelBuilder implements FormattingModelBuilder
{
    private static final Logger LOG = Logger.getInstance(BeancountFormattingModelBuilder.class);

    @NotNull
    @Override
    public FormattingModel createModel(FormattingContext formattingContext)
    {
        PsiElement element = formattingContext.getPsiElement();
        CodeStyleSettings settings = formattingContext.getCodeStyleSettings();
        LOG.info("createModel");
        Stopwatch watch = Stopwatch.createStarted();
        int longestAccountLength = -1;
        int longestExprLength = -2;
        if (element.getContainingFile() instanceof BeancountFile file)
        {
            longestAccountLength = new AccountsCompleter(file).lengthOfLongestAccount();
            LOG.info("indexed accoutns: " + watch.elapsed(TimeUnit.SECONDS));
            longestExprLength = BeancountTreeUtil
                .findMatchesRecursively(file, el -> el instanceof BeancountAmount)
                .map(BeancountAmount.class::cast)
                .map(BeancountAmount::getExpr)
                .map(BeancountExpr::getLengthPreDecimalWithAccount)
                .max().getOrElse(-1);
            LOG.info("longestexpr: " + watch.elapsed(TimeUnit.SECONDS));

        }

        return FormattingModelProvider
            .createFormattingModelForPsiFile(element.getContainingFile(),
                new BeancountBlock(longestAccountLength, longestExprLength, element.getNode(),
                    Wrap.createWrap(WrapType.NONE, false),
                    Alignment.createAlignment(),
                    createSpaceBuilder(settings)),
                settings);

    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings)
    {
        return new SpacingBuilder(settings, BeancountLanguage.INSTANCE)
            .between(EXPR, CURRENCY)
            .spaces(1)
            .after(DATE)
            .spaces(1)
            .after(BeancountTypeUtil.DIRECTIVE_KEYWORDS)
            .spaces(1)
            .after(META_KEY)
            .none()
            .after(META_KV_DELIMITER)
            .spaces(1)
            .between(BeancountTypes.UNARY_MIN_EXPR, BeancountTypes.LITERAL_EXPR)
            .none()
            .between(BeancountTypes.UNARY_PLUS_EXPR, BeancountTypes.LITERAL_EXPR)
            .none()
            .between(BeancountTypes.AMOUNT, BeancountTypes.COMMA)
            .spaces(1)
            .between(BeancountTypes.LCURL, BeancountTypes.COST_COMP_LIST)
            .none()
            .between(BeancountTypes.COST_COMP_LIST, BeancountTypes.RCURL)
            .none()
            .between(BeancountTypes.COST_SPEC, BeancountTypes.POSTING_PRICE)
            .spaces(1)
            .between(BeancountTypes.AT, BeancountTypes.EXPR)
            .spaces(1);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset)
    {
        return null;
    }
}
