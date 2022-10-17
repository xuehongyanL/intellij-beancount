package space.wanderful.intellij.plugin.beancount.psi;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.intellij.psi.tree.IElementType;
import space.wanderful.intellij.plugin.beancount.BeancountLanguage;

public class BeancountTokenType
    extends IElementType

{
    public BeancountTokenType(@NotNull @NonNls String debugName)
    {
        super(debugName, BeancountLanguage.INSTANCE);
    }
}
