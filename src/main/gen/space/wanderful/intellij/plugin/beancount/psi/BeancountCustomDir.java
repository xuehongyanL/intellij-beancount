// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BeancountCustomDir extends PsiElement {

  @NotNull
  List<BeancountAccount> getAccountList();

  @NotNull
  List<BeancountAmount> getAmountList();

  @NotNull
  List<BeancountExpr> getExprList();

}
