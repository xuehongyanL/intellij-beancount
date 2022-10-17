// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static space.wanderful.intellij.plugin.beancount.psi.BeancountTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import space.wanderful.intellij.plugin.beancount.psi.*;

public class BeancountCompoundAmountImpl extends ASTWrapperPsiElement implements BeancountCompoundAmount {

  public BeancountCompoundAmountImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BeancountVisitor visitor) {
    visitor.visitCompoundAmount(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BeancountVisitor) accept((BeancountVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BeancountAmount getAmount() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, BeancountAmount.class));
  }

  @Override
  @NotNull
  public BeancountExpr getExpr() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, BeancountExpr.class));
  }

}
