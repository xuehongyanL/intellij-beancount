package space.wanderful.intellij.plugin.beancount.psi.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import io.vavr.Function2;
import org.jetbrains.annotations.NotNull;

/**
 * A functional wrapper around {@link PsiScopeProcessor}
 */
public abstract class BeancountScopeProcessor implements PsiScopeProcessor {
    public static boolean RESOLVE_CONTINUE = true;
    public static boolean RESOLVE_FINISHED = false;

    public static BeancountScopeProcessor of(
        Function2<PsiElement, ResolveState, Boolean> executor)
    {
        return new BeancountScopeProcessor()
        {

            @Override
            public boolean execute(@NotNull final PsiElement element,
                @NotNull final ResolveState state)
            {
                return executor.apply(element, state);
            }
        };
    }
}
