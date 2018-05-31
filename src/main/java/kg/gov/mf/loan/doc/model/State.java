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
                    return transition == REGISTER ? REGISTERED : ACCEPTED;
                }

                @Override
                public String stringValue()
                {
                    return "Утверж";
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
                    return "";
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
                    return "";
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
                    return "";
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
                    return "";
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
                    return "";
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
                    return "";
                }
            };

    public abstract State next(Transition transition);
    public abstract String stringValue();
}
