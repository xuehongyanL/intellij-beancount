// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.*;
import space.wanderful.intellij.plugin.beancount.psi.*;
import com.intellij.psi.PsiReference;
import space.wanderful.intellij.plugin.beancount.psi.stub.CurrencySymbolStub;
import com.intellij.psi.stubs.IStubElementType;

public class BeancountCurrencySymbolImpl extends BeancountCurrencyElementImpl implements BeancountCurrencySymbol {

  public BeancountCurrencySymbolImpl(@NotNull CurrencySymbolStub stub, @NotNull IStubElementType type) {
    super(stub, type);
  }

  public BeancountCurrencySymbolImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BeancountVisitor visitor) {
    visitor.visitCurrencySymbol(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BeancountVisitor) accept((BeancountVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getName() {
    return BeancountPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return BeancountPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return BeancountPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiReference getReference() {
    return BeancountPsiImplUtil.getReference(this);
  }

}
