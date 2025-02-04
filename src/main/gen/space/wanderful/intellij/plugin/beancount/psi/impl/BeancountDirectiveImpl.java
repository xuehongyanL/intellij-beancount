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

public class BeancountDirectiveImpl extends ASTWrapperPsiElement implements BeancountDirective {

  public BeancountDirectiveImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BeancountVisitor visitor) {
    visitor.visitDirective(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BeancountVisitor) accept((BeancountVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BeancountBalanceDir getBalanceDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountBalanceDir.class);
  }

  @Override
  @Nullable
  public BeancountCommodityDir getCommodityDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountCommodityDir.class);
  }

  @Override
  @Nullable
  public BeancountCustomDir getCustomDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountCustomDir.class);
  }

  @Override
  @Nullable
  public BeancountDocumentDir getDocumentDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountDocumentDir.class);
  }

  @Override
  @Nullable
  public BeancountEventDir getEventDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountEventDir.class);
  }

  @Override
  @Nullable
  public BeancountNoteDir getNoteDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountNoteDir.class);
  }

  @Override
  @Nullable
  public BeancountOpenDir getOpenDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountOpenDir.class);
  }

  @Override
  @Nullable
  public BeancountPadDir getPadDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountPadDir.class);
  }

  @Override
  @Nullable
  public BeancountPriceDir getPriceDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountPriceDir.class);
  }

  @Override
  @Nullable
  public BeancountQueryDir getQueryDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountQueryDir.class);
  }

  @Override
  @Nullable
  public BeancountTransactionDir getTransactionDir() {
    return PsiTreeUtil.getChildOfType(this, BeancountTransactionDir.class);
  }

}
