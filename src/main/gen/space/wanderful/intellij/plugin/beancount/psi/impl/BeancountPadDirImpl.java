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

public class BeancountPadDirImpl extends ASTWrapperPsiElement implements BeancountPadDir {

  public BeancountPadDirImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BeancountVisitor visitor) {
    visitor.visitPadDir(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BeancountVisitor) accept((BeancountVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BeancountAccount> getAccountList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BeancountAccount.class);
  }

}
