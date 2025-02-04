package space.wanderful.intellij.plugin.beancount.features.completion;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.or;
import static com.intellij.psi.TokenType.ERROR_ELEMENT;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.ACCOUNT_WORD;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.CURRENCY;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.DATE;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.NEGATIVE_NUMBER;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.NUMBER;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import space.wanderful.intellij.plugin.beancount.BeancountLanguage;

public class BeancountCompletionContributor extends CompletionContributor
{
    public BeancountCompletionContributor()
    {
        // :: accounts
        extend(
            CompletionType.BASIC,
            psiElement(ACCOUNT_WORD)
                .andNot(psiElement(ACCOUNT_WORD).afterSibling(psiElement(NUMBER)))
                .withLanguage(BeancountLanguage.INSTANCE),
            new BeancountAccountCompletionProvider()
        );

        // :: currency
        extend(CompletionType.BASIC,
            psiElement(CURRENCY)
            , new BeancountCurrencyCompletionProvider());

        extend(CompletionType.BASIC,
            psiElement().withParent(psiElement(ERROR_ELEMENT)
                .afterSibling(psiElement(WHITE_SPACE)
                    .afterSibling(or(psiElement(NUMBER), psiElement(NEGATIVE_NUMBER)))))
            , new BeancountCurrencyCompletionProvider());

        // :: directives
        extend(
            CompletionType.BASIC,
            psiElement()
                .withParent(psiElement(ERROR_ELEMENT)
                    .afterSibling(psiElement(WHITE_SPACE)
                        .afterSibling(psiElement(DATE))))
            , new BeancountDirectiveCompletionProvider()
        );

        extend(
            CompletionType.BASIC,
            psiElement()
                .withParent(psiElement()
                    .afterSibling(psiElement(ERROR_ELEMENT)
                        .afterSibling(psiElement(WHITE_SPACE)
                            .afterSibling(psiElement(DATE)))))
            , new BeancountDirectiveCompletionProvider()
        );
    }
}
