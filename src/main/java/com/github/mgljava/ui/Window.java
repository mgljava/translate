package com.github.mgljava.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import org.jetbrains.annotations.NotNull;

/**
 * UI界面
 */
public class Window implements ToolWindowFactory, ActionListener {

  private JPanel mPanel1;
  private JTextField mInput;
  private JButton mSubmitButton;
  private JTextArea mResultArea;

  @Override
  public void init(ToolWindow window) {
    this.mPanel1 = new JPanel();
    this.mInput = new JTextField("", 25);
    this.mSubmitButton = new JButton("翻译");
    this.mResultArea = new JTextArea(5, 47);
    this.mInput.registerKeyboardAction(this, KeyStroke.getKeyStroke(10, 0, true), 0);
    this.mSubmitButton.addActionListener(this);
    mPanel1.add(mInput);
    mPanel1.add(mSubmitButton);
    mPanel1.add(mResultArea);
  }

  @Override
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(this.mPanel1, "", false);
    toolWindow.getContentManager().addContent(content);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String word = this.mInput.getText();
    /*if (StringUtils.isBlank(word)) {
      this.mResultArea.setText("请输入你的名字");
      this.mInput.setText("");
    }*/
    String stringBuilder = "您输入的单词："
        + word
        + " 涉及到网络安全，已经被限制。\n请好自为之，维护网络安全环境，人人有责!";
    this.mResultArea.setText(stringBuilder);
  }
}
