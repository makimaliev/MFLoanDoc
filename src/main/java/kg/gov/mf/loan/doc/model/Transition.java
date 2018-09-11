package kg.gov.mf.loan.doc.model;

public enum Transition
{
    NONE            // 0
            {
                @Override
                public State state() {
                    return null;
                }

                @Override
                public String text() {
                    return "";
                }
            },
    CREATE          // 1
            {
                @Override
                public State state() {
                    return State.DRAFT;
                }

                @Override
                public String text() {
                    return "Создать";
                }
            },
    TORECONCILE     // 2
            {
                @Override
                public State state() {
                    return State.PENDING;
                }

                @Override
                public String text() {
                    return "На согласование";
                }
            },
    RECONCILE       // 3
            {
                @Override
                public State state() {
                    return State.RECONCILED;
                }

                @Override
                public String text() {
                    return "Согласовать";
                }
            },
    REQUEST         // 4
            {
                @Override
                public State state() {
                    return State.REQUESTED;
                }

                @Override
                public String text() {
                    return "На рассмотрение";
                }
            },
    APPROVE         // 5
            {
                @Override
                public State state() {
                    return State.APPROVED;
                }

                @Override
                public String text() {
                    return "Утвердить";
                }
            },
    REJECT          // 6
            {
                @Override
                public State state() {
                    return State.REJECTED;
                }

                @Override
                public String text() {
                    return "Отклонить";
                }
            },
    REGISTER        // 7
            {
                @Override
                public State state() {
                    return State.REGISTERED;
                }

                @Override
                public String text() {
                    return "Зарегистрировать";
                }
            },
    ACCEPT          // 8
            {
                @Override
                public State state() {
                    return State.ACCEPTED;
                }

                @Override
                public String text() {
                    return "Принять";
                }
            },
    SEND            // 9
            {
                @Override
                public State state() {
                    return State.SENT;
                }

                @Override
                public String text() {
                    return "Отправить на исполнение";
                }
            },
    START           // 10
            {
                @Override
                public State state() {
                    return State.STARTED;
                }

                @Override
                public String text() {
                    return "Начать";
                }
            },
    DONE            // 11
            {
                @Override
                public State state() {
                    return State.DONE;
                }

                @Override
                public String text() {
                    return "Завершить";
                }
            };

    public abstract State state();
    public abstract String text();
}
