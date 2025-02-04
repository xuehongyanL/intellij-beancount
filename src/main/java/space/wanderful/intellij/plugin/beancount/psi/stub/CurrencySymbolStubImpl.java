package space.wanderful.intellij.plugin.beancount.psi.stub;

import org.jetbrains.annotations.NotNull;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import space.wanderful.intellij.plugin.beancount.psi.BeancountCurrencySymbol;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTypes;

public class CurrencySymbolStubImpl extends BeancountStubImpl<BeancountCurrencySymbol>
    implements CurrencySymbolStub
{
    public CurrencySymbolStubImpl(@NotNull final StubElement parent, @NotNull String currencyName)
    {
        super(parent, (IStubElementType) BeancountTypes.CURRENCY_SYMBOL,
            StringRef.fromString(currencyName));
    }
}
