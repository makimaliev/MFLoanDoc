package kg.gov.mf.loan.doc.model;

import static kg.gov.mf.loan.doc.model.Transition.*;

public enum State
{
    NEW
            {
                @Override
                public State next(Transition transition) {

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
    DRAFT
            {
                @Override
                public State next(Transition transition) {
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
    REQUESTED
            {
                @Override
                public State next(Transition transition) {

                    return transition == REJECT ? REJECTED : APPROVED;
                }

                @Override
                public String stringValue()
                {
                    return "На расмотрении";
                }
            },
    APPROVED
            {
                @Override
                public State next(Transition transition) {
                    
                    if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else if(transition == ACCEPT)
                    {
                        return ACCEPTED;
                    }
                    else
                    {
                        return DONE;
                    }

                    //return transition == REGISTER ? REGISTERED : ACCEPTED;
                }

                @Override
                public String stringValue()
                {
                    return "Утвержден";
                }
            },
    REJECTED
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
    REGISTERED
            {
                @Override
                public State next(Transition transition) {
                    return transition == Transition.ACCEPT ? ACCEPTED : ARCHIVED;
                }

                @Override
                public String stringValue()
                {
                    return "Зарегистрирован";
                }
            },
    ACCEPTED
            {
                @Override
                public State next(Transition transition)
                {
                    return STARTED;
                }

                @Override
                public String stringValue()
                {
                    return "Принят";
                }
            },
    STARTED
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
    DONE
            {
                @Override
                public State next(Transition transition)
                {
                    return ARCHIVED;
                }

                @Override
                public String stringValue()
                {
                    return "Завершен";
                }
            },
    ARCHIVED
            {
                @Override
                public State next(Transition transition)
                {
                    return ARCHIVED;
                }

                @Override
                public String stringValue()
                {
                    return "Архивирован";
                }
            };

    public abstract State next(Transition transition);
    public abstract String stringValue();
}
