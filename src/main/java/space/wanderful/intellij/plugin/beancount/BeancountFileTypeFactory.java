package space.wanderful.intellij.plugin.beancount;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

public class BeancountFileTypeFactory extends FileTypeFactory
{
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer)
    {
        fileTypeConsumer.consume(space.wanderful.intellij.plugin.beancount.BeancountFileType.INSTANCE, "bean;beancount");
    }
}
