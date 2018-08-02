package kg.gov.mf.loan.doc.model;

public enum Transition
{
    NONE
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
    CREATE
            {
                @Override
                public State state() {
                    return State.NEW;
                }

                @Override
                public String text() {
                    return "Сохранить";
                }
            },
    TORECONCILE
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
    RECONCILE
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
    REQUEST
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
    APPROVE
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
    REJECT
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
    REGISTER
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
    ACCEPT
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
    SEND
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
    START
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
    DONE
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
