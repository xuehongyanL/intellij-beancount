package space.wanderful.intellij.plugin.beancount.features.references;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import space.wanderful.intellij.plugin.beancount.parser.BeancountLexer;
import space.wanderful.intellij.plugin.beancount.psi.BeancountAccount;
import space.wanderful.intellij.plugin.beancount.psi.BeancountCurrencySymbol;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTypes;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountNamedElement;

public class BeancountFindUsagesProvider implements FindUsagesProvider
{
    @Nullable
    @Override
    public WordsScanner getWordsScanner()
    {
        return new DefaultWordsScanner(new BeancountLexer(),
            TokenSet.create(BeancountTypes.ACCOUNT, BeancountTypes.ACCOUNT_WORD,
                BeancountTypes.CURRENCY),
            TokenSet.create(BeancountTypes.COMMENT),
            TokenSet.create(BeancountTypes.STRING));
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement)
    {
        return psiElement instanceof BeancountNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement)
    {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element)
    {
        if (element instanceof BeancountAccount)
            return "account";
        else if (element instanceof BeancountCurrencySymbol)
            return "currencysymbol";
        else
            return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element)
    {
        if (element instanceof BeancountNamedElement)
            return ((BeancountNamedElement) element).getName();
        else
            return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName)
    {
        if (element instanceof BeancountNamedElement)
        {
            return ((BeancountNamedElement) element).getName();
        } else
        {
            return "";
        }
    }
}

