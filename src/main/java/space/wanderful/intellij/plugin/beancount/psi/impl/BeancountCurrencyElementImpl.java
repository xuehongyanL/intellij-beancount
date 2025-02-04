package space.wanderful.intellij.plugin.beancount.psi.impl;

import org.jetbrains.annotations.NotNull;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountCurrencyElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.CurrencySymbolStub;

public abstract class BeancountCurrencyElementImpl
    extends StubBasedPsiElementBase<CurrencySymbolStub>
    implements BeancountCurrencyElement
{
    public BeancountCurrencyElementImpl(@NotNull final CurrencySymbolStub stub,
        @NotNull final IStubElementType nodeType)
    {
        super(stub, nodeType);
    }

    public BeancountCurrencyElementImpl(@NotNull final ASTNode node)
    {
        super(node);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "(" + this.getElementType().toString() + ")";
    }
}
