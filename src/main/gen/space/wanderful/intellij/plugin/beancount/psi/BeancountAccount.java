// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import space.wanderful.intellij.plugin.beancount.psi.elements.BeancountAccountElement;
import com.intellij.psi.StubBasedPsiElement;
import space.wanderful.intellij.plugin.beancount.psi.stub.AccountStub;
import com.intellij.psi.PsiReference;

public interface BeancountAccount extends BeancountAccountElement, StubBasedPsiElement<AccountStub> {

  @NotNull
  List<BeancountAccountSegment> getAccountSegmentList();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiReference getReference();

}
