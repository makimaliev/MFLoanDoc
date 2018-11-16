package kg.gov.mf.loan.doc.model;

import static kg.gov.mf.loan.doc.model.Transition.*;

public enum State
{
    NEW         // 0
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REQUEST)
                    {
                        return REQUESTED;
                    }
                    else if(transition == TORECONCILE)
                    {
                        return PENDING;
                    }
                    else if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else
                    {
                        return DRAFT;
                    }
                }

                @Override
                public String text() {
                    return "Новый";
                }
            },
    DRAFT       // 1
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else if(transition == TORECONCILE)
                    {
                        return PENDING;
                    }
                    else
                    {
                        return REQUESTED;
                    }
                }

                @Override
                public String text() {
                    return "Создан";
                }
            },
    PENDING     // 2
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REJECT)
                    {
                        return DRAFT;
                    }
                    else
                    {
                        return RECONCILED;
                    }
                }

                @Override
                public String text() {
                    return "Отправлен на согласование";
                }
            },
    RECONCILED  // 3
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == TORECONCILE)
                    {
                        return PENDING;
                    }
                    else
                    {
                        return REQUESTED;
                    }
                }

                @Override
                public String text() {
                    return "Согласован";
                }
            },
    REQUESTED   // 4
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REJECT)
                    {
                        return DRAFT;
                    }
                    else if(transition == RECONCILE)
                    {
                        return RECONCILED;
                    }
                    else
                    {
                        return APPROVED;
                    }
                }

                @Override
                public String text() {
                    return "Отправлен на утверждение";
                }
            },
    APPROVED    // 5
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else if(transition == ACCEPT)
                    {
                        return ACCEPTED;
                    }
                    else if(transition == REJECT)
                    {
                        return DRAFT;
                    }
                    else
                    {
                        return DONE;
                    }
                }

                @Override
                public String text() {
                    return "Утвержден";
                }
            },
    REJECTED    // 6
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REQUEST)
                    {
                        return REQUESTED;
                    }
                    else if(transition == TORECONCILE)
                    {
                        return RECONCILED;
                    }
                    else if(transition == ACCEPT)
                    {
                        return ACCEPTED;
                    }
                    else {
                        return DONE;
                    }
                }

                @Override
                public String text() {
                    return "Отклонен";
                }
            },
    REGISTERED  // 7
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == ACCEPT)
                    {
                        return ACCEPTED;
                    }
                    else if(transition == SEND)
                    {
                        return SENT;
                    }
                    else if(transition == REJECT)
                    {
                        return DRAFT;
                    }
                    else
                    {
                        return DONE;
                    }
                }

                @Override
                public String text() {
                    return "Зарегистрирован";
                }
            },
    ACCEPTED    // 8
            {
                @Override
                public State next(Transition transition)
                {
                    return SENT;
                }

                @Override
                public String text() {
                    return "Принят";
                }
            },
    SENT        // 9
            {
                @Override
                public State next(Transition transition)
                {
                    if(transition == REJECT)
                    {
                        return ACCEPTED;
                    }

                    else if(transition == SEND)
                    {
                        return SENT;
                    }

                    else
                    {
                        return STARTED;
                    }
                }

                @Override
                public String text() {
                    return "Отправлен на исполнение";
                }
            },
    STARTED     // 10
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }

                @Override
                public String text() {
                    return "Начат";
                }
            },
    DONE        // 11
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }

                @Override
                public String text() {
                    return "Завершен";
                }
            };

    public abstract State next(Transition transition);
    public abstract String text();
}
