package space.wanderful.intellij.plugin.beancount.psi.reference;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import space.wanderful.intellij.plugin.beancount.psi.BeancountAccount;
import space.wanderful.intellij.plugin.beancount.psi.BeancountOpenDir;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTreeUtil;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountNamedElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.index.AccountStubIndex;


public class BeancountAccountReference extends BeancountReference<BeancountAccount>
{
    public BeancountAccountReference(BeancountAccount element, TextRange range)
    {
        super(element, range);
    }

    @Override
    Collection<BeancountAccount> getFromCache(final Project project, final String elementText)
    {
        return AccountStubIndex.find(project, elementText);
    }

    @Override
    protected boolean isElementToResolve(final BeancountAccount elementToSearch,
        final BeancountNamedElement maybeElementDeclaration)
    {
        if (maybeElementDeclaration instanceof BeancountAccount)
        {
            return isAccountDeclaration(elementToSearch,
                (BeancountAccount) maybeElementDeclaration);
        }
        return false;
    }

    /**
     * Is maybeAccountDeclaration the instance that declares the account in accountToSearch?
     *
     * @param accountToSearch
     * @param maybeAccountDeclaration
     * @return
     */
    private static boolean isAccountDeclaration(BeancountAccount accountToSearch,
        BeancountAccount maybeAccountDeclaration)
    {

        if (StringUtils.equals(maybeAccountDeclaration.getName(), accountToSearch.getName()))
        {
            Optional<PsiElement> maybeOpenDirective = BeancountTreeUtil
                .findParent(maybeAccountDeclaration,
                    parent -> parent instanceof BeancountOpenDir);

            return maybeOpenDirective.isPresent();
        }
        return false;
    }

}
