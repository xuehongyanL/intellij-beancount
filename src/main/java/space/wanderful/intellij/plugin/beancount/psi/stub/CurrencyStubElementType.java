package space.wanderful.intellij.plugin.beancount.psi.stub;

import java.io.IOException;

import org.jetbrains.annotations.NotNull;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;
import space.wanderful.intellij.plugin.beancount.BeancountLanguage;
import space.wanderful.intellij.plugin.beancount.psi.BeancountCurrencySymbol;
import space.wanderful.intellij.plugin.beancount.psi.impl.BeancountCurrencySymbolImpl;
import space.wanderful.intellij.plugin.beancount.psi.stub.index.BeancountCurrencySymbolKeyIndex;

public class CurrencyStubElementType
    extends IStubElementType<CurrencySymbolStub, BeancountCurrencySymbol>
{
    public CurrencyStubElementType()
    {
        super("ACCOUNT", BeancountLanguage.INSTANCE);
    }

    public BeancountCurrencySymbol createPsi(@NotNull final CurrencySymbolStub stub)
    {
        return new BeancountCurrencySymbolImpl(stub, this);
    }

    @NotNull
    public CurrencySymbolStub createStub(@NotNull final BeancountCurrencySymbol psi,
        final StubElement parentStub)
    {
        return new CurrencySymbolStubImpl(parentStub, psi.getName());
    }

    @NotNull
    public String getExternalId()
    {
        return "Beancount.CurrencySymbol";
    }

    public void serialize(@NotNull final CurrencySymbolStub stub,
        @NotNull final StubOutputStream dataStream) throws
        IOException
    {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    public CurrencySymbolStub deserialize(@NotNull final StubInputStream dataStream,
        final StubElement parentStub) throws IOException
    {
        final StringRef ref = dataStream.readName();
        return new CurrencySymbolStubImpl(parentStub, ref.getString());
    }

    public void indexStub(@NotNull final CurrencySymbolStub stub, @NotNull final IndexSink sink)
    {
        sink.occurrence(BeancountCurrencySymbolKeyIndex.KEY, stub.getName());
    }

}
