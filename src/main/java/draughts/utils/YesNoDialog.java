package draughts.utils;

public class YesNoDialog  extends WithConsoleModel {

    private static final char AFIRMATIVE = 's';

    private static final char NEGATIVE = 'n';

    private static final String QUESTION = "? ("+YesNoDialog.AFIRMATIVE+"/"+YesNoDialog.NEGATIVE+"): ";

    private static final String MESSAGE = "El valor debe ser '" + YesNoDialog.AFIRMATIVE + "' o '"
                    + YesNoDialog.NEGATIVE + "'";

    public boolean read() {
        char answer;
        boolean ok;
        do {
            answer = this.console.readChar(YesNoDialog.QUESTION);
            ok = YesNoDialog.isAfirmative(answer) || YesNoDialog.isNegative(answer);
            if (!ok) {
                this.console.writeln(YesNoDialog.MESSAGE);
            }
        } while (!ok);
        return YesNoDialog.isAfirmative(answer);
    }

    private static boolean isAfirmative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.AFIRMATIVE;
    }

    private static boolean isNegative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.NEGATIVE;
    }
}