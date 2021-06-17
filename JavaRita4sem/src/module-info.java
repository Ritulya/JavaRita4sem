// Добавляем описание модуля в корень src/
module javafxexample {
    // указываем, какими другими модулями должен
    // пользоваться наш.
    // От этого зависит набор классов, к которым
    // у нас есть доступ из программы.
    requires javafx.base;
    requires javafx.controls;

    //! мы должны разрешить JavaFX анализировать наш код
    //указываем пакет с javafx кодом
    opens javafxexamples;
    opens tasks;
}