package space.wanderful.intellij.plugin.beancount.psi.stub.index;

import org.jetbrains.annotations.NotNull;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import space.wanderful.intellij.plugin.beancount.psi.BeancountCurrencySymbol;

public class BeancountCurrencySymbolKeyIndex
    extends StringStubIndexExtension<BeancountCurrencySymbol>
{
    public static final StubIndexKey<String, BeancountCurrencySymbol> KEY = StubIndexKey
        .createIndexKey("beancount.currencysymbol.index");

    @NotNull
    @Override
    public StubIndexKey<String, BeancountCurrencySymbol> getKey()
    {
        return KEY;
    }
}
