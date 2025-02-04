// This is a generated file. Not intended for manual editing.
package space.wanderful.intellij.plugin.beancount.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BeancountTransactionDir extends PsiElement {

  @NotNull
  List<BeancountKeyValue> getKeyValueList();

  @Nullable
  BeancountPostingList getPostingList();

  @NotNull
  List<BeancountTagLink> getTagLinkList();

}
