package com.etg;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by cuke on 2018/8/1.
 */
public class openEventTrigger extends AnAction {

    public void actionPerformed(AnActionEvent e) {

        //MessageBus messageBus = e.getProject().getMessageBus();
        //MessageBusConnection connection = messageBus.connect();
        //connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
        //    @Override
        //    public void fileOpened(FileEditorManager source, VirtualFile file) {
        //        try {
        //            String result = new BufferedReader(new InputStreamReader(file.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
        //            System.out.println(result);
        //        } catch (IOException e1) {
        //            e1.printStackTrace();
        //        }
        //    }
        //
        //    @Override
        //    public void fileClosed(FileEditorManager source, VirtualFile file) {
        //
        //    }
        //});

        //DataManager.getInstance().getDataContext()
        //new CheckboxAction() {
        //    @Override
        //    public boolean isSelected(AnActionEvent anActionEvent) {
        //        return false;
        //    }
        //
        //    @Override
        //    public void setSelected(AnActionEvent anActionEvent, boolean b) {
        //
        //    }
        //}.createCustomComponent(new Presentation());
        //
        ////AnActionEvent.createFromAnAction(this.);
        //ProjectManagerImpl.getInstance().addProjectManagerListener(new ProjectManagerListener() {
        //
        //    @Override
        //    public void projectOpened(Project project) {
        //
        //    }
        //
        //    @Override
        //    public boolean canCloseProject(Project project) {
        //        return false;
        //    }
        //
        //    @Override
        //    public void projectClosed(Project project) {
        //
        //    }
        //
        //    @Override
        //    public void projectClosing(Project project) {
        //
        //    }
        //});
        //
        //new MenuItem();

    }
}
