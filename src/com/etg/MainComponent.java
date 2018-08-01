package com.etg;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.project.impl.ProjectManagerImpl;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by cuke on 2018/8/1.
 */
public class MainComponent implements ApplicationComponent {

    MessageBusConnection connection;
    @Override
    public void initComponent() {

        ProjectManagerImpl.getInstance().addProjectManagerListener(new ProjectManagerListener() {

            @Override
            public void projectOpened(Project project) {

                //MessageBus messageBus = project.getMessageBus();
                //MessageBusConnection connection = messageBus.connect();

                MessageBus bus = ApplicationManager.getApplication().getMessageBus();
                connection = bus.connect();

                connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
                    @Override
                    public void fileOpened(FileEditorManager source, VirtualFile file) {
                        try {
                            String result = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
                            System.out.println(result);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void fileClosed(FileEditorManager source, VirtualFile file) {

                    }
                });

            }

            @Override
            public boolean canCloseProject(Project project) {
                return false;
            }

            @Override
            public void projectClosed(Project project) {

            }

            @Override
            public void projectClosing(Project project) {

            }
        });
    }

    @Override
    public void disposeComponent() {
        connection.disconnect();
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "Cuke Event Runner";
    }
}
