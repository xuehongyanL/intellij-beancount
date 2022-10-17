// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountCurrencyElement;
import com.intellij.psi.StubBasedPsiElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.CurrencySymbolStub;
import com.intellij.psi.PsiReference;

public interface BeancountCurrencySymbol extends BeancountCurrencyElement, StubBasedPsiElement<CurrencySymbolStub> {

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiReference getReference();

}
