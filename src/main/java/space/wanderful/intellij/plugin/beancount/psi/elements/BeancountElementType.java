package space.wanderful.intellij.plugin.beancount.psi.elements;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.intellij.psi.tree.IElementType;
import space.wanderful.intellij.plugin.beancount.BeancountLanguage;

public class BeancountElementType extends IElementType
{
    public BeancountElementType(@NotNull @NonNls String debugName)
    {
        super(debugName, BeancountLanguage.INSTANCE);
    }
}
