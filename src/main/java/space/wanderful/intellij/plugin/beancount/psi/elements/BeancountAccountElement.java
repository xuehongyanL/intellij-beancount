package space.wanderful.intellij.plugin.beancount.psi.elements;

import com.intellij.psi.StubBasedPsiElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.AccountStub;

public interface BeancountAccountElement
    extends BeancountNamedElement, StubBasedPsiElement<AccountStub>
{
}
