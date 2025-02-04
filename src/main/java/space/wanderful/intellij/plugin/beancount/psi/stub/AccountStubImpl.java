package space.wanderful.intellij.plugin.beancount.psi.stub;

import org.jetbrains.annotations.NotNull;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import space.wanderful.intellij.plugin.beancount.psi.BeancountAccount;
import space.wanderful.intellij.plugin.beancount.psi.BeancountTypes;

public class AccountStubImpl extends BeancountStubImpl<BeancountAccount> implements AccountStub
{
    public AccountStubImpl(@NotNull final StubElement parent, @NotNull String accountName)
    {
        super(parent, (IStubElementType) BeancountTypes.ACCOUNT, StringRef.fromString(accountName));
    }
}
