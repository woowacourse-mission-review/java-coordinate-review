package coordinates.view;

public class ConsoleOutputView implements OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "ERROR : ";

    @Override
    public void showExceptionMessage(final Exception e) {
        System.out.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
    }
}
