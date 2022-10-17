package space.wanderful.intellij.plugin.beancount.psi.elements;

import com.intellij.psi.StubBasedPsiElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.CurrencySymbolStub;

public interface BeancountCurrencyElement
    extends BeancountNamedElement, StubBasedPsiElement<CurrencySymbolStub>
{
}
