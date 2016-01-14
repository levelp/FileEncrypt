import javax.swing.*;

/**
 * Шифрование файлов
 */
public class MainForm {
    private JTextField srcFileName;
    private JTextField dstFileName;
    private JButton encryptButton;
    private JPasswordField password;
    private JPanel mainPanel;

    public MainForm() {
        encryptButton.addActionListener(actionEvent -> {
            Encoder encoder = new Encoder(srcFileName.getText(),
                    dstFileName.getText(), password.getPassword());
        });
    }

    public static void main(String[] args) {
        // Создаём окно и задаём ему заголовок
        JFrame frame = new JFrame("Шифрование / расшифровка файла с помощью XOR");
        // Создаём класс, соответствующий нашей форме
        MainForm mainForm = new MainForm();
        // Основную панель помещаем внутрь окна
        frame.setContentPane(mainForm.mainPanel);
        // Размещение компонент внутри окна
        // рекурсивное определение размеров компонент
        frame.pack();
        // Когда закрываем этот frame => закроется всё приложение
        // Обычно задаётся для "основного" окна приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Показываем окно
        frame.setVisible(true);
    }
}
