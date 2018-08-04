package com.etg;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.impl.ProjectManagerImpl;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBusConnection;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by cuke on 2018/8/3.
 */
public class ProjComponent implements ProjectComponent {


    public void fileOpenEventReg(){

        ProjectManager projectManager = ProjectManagerImpl.getInstance();
        Project e = projectManager.getOpenProjects()[0];
        System.out.println(e.getBasePath());
        System.out.println(e.getName());

        MessageBusConnection connection = e.getMessageBus().connect(e);
        connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new  FileEditorManagerAdapter() {
            @Override
            public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
                try {
                    String result = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
                    System.out.println(result);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


//        MessageBus messageBus = e.getMessageBus();
//        connection = messageBus.connect();
//        connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
//            @Override
//            public void fileOpened(FileEditorManager source, VirtualFile file) {
//                try {
//                    String result = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
//                    System.out.println(result);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//            @Override
//            public void fileClosed(FileEditorManager source, VirtualFile file) {
//
//            }
//        });

//        projectManager.addProjectManagerListener(new ProjectManagerAdapter() {
//            @Override
//            public void projectOpened(final Project project) {
//                // validate all editors are disposed after fireProjectClosed() was called, because it's the place where editor should be released
//                Disposer.register(project, new Disposable() {
//                    @Override
//                    public void dispose() {
//                        final Project[] openProjects = ProjectManager.getInstance().getOpenProjects();
//                        final boolean isLastProjectClosed = openProjects.length == 0;
////                        validateEditorsAreReleased(project, isLastProjectClosed);
//
//                        try {
//                            String result = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
//                            System.out.println(result);
//                        } catch (IOException e1) {
//                            e1.printStackTrace();
//        //                }
//
//                    }
//                });
//            }
//        });
    }

    @Override
    public void projectOpened() {
        System.out.println("projectOpened");
        fileOpenEventReg();
    }

    @Override
    public void projectClosed() {
        System.out.println("projectClosed");
    }

    @Override
    public void initComponent() {
        System.out.println("initComponent");
    }

    @Override
    public void disposeComponent() {
        System.out.println("disposeComponent");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "getComponentName";
    }
}
