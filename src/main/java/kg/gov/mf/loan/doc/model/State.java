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
                    if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else
                    {
                        return DRAFT;
                    }
                }

                @Override
                public String stringValue()
                {
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
                    else
                    {
                        return REQUESTED;
                    }
                }

                @Override
                public String stringValue()
                {
                    return "Создан";
                }
            },
    REQUESTED   // 2
            {
                @Override
                public State next(Transition transition)
                {
                    return transition == REJECT ? DRAFT : APPROVED;
                }

                @Override
                public String stringValue()
                {
                    return "Отправлен на расмотрение";
                }
            },
    APPROVED    // 3
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
                public String stringValue()
                {
                    return "Утвержден";
                }
            },
    REJECTED    // 4
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }

                @Override
                public String stringValue()
                {
                    return "Отклонен";
                }
            },
    REGISTERED  // 5
            {
                @Override
                public State next(Transition transition)
                {
                    //return transition == Transition.ACCEPT ? ACCEPTED : DONE;
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
                public String stringValue()
                {
                    return "Зарегистрирован";
                }
            },
    ACCEPTED    // 6
            {
                @Override
                public State next(Transition transition)
                {
                    return SENT;
                }

                @Override
                public String stringValue()
                {
                    return "Принят";
                }
            },
    SENT        // 7
            {
                @Override
                public State next(Transition transition)
                {
                    return transition == REJECT ? ACCEPTED : STARTED;
                }

                @Override
                public String stringValue()
                {
                    return "Отправлен на исполнение";
                }
            },
    STARTED     // 8
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }

                @Override
                public String stringValue()
                {
                    return "Начат";
                }
            },
    DONE        // 9
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }

                @Override
                public String stringValue()
                {
                    return "Завершен";
                }
            };

    public abstract State next(Transition transition);
    public abstract String stringValue();
}
