package kg.gov.mf.loan.doc.model;

import static kg.gov.mf.loan.doc.model.Transition.*;

public enum State
{
    DRAFT
            {
                @Override
                public State next(Transition transition)
                {
                    // REGISTER -> REGISTERED || NONE -> WAITING_FOR_APPROVAL
                    if(transition == CREATE)
                    {
                        return DRAFT;
                    }
                    if(transition == REGISTER)
                    {
                        return REGISTERED;
                    }
                    else
                    {
                        return WAITING_FOR_APPROVAL;
                    }
                }
            },
    WAITING_FOR_APPROVAL
            {
                @Override
                public State next(Transition transition)
                {
                    // REJECT -> REJECTED || NONE -> APPROVED
                    return transition == REJECT ? REJECTED : APPROVED;
                }
            },
    APPROVED
            {
                @Override
                public State next(Transition transition)
                {
                    // REGISTER -> REGISTERED || NONE -> ACCEPTED
                    return transition == REGISTER ? REGISTERED : ACCEPTED;
                }
            },
    REJECTED
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }
            },
    REGISTERED
            {
                @Override
                public State next(Transition transition)
                {
                    // ACCEPT -> ACCEPTED || ANY -> ARCHIVED
                    return transition == Transition.ACCEPT ? ACCEPTED : ARCHIVED;
                }
            },
    ACCEPTED
            {
                @Override
                public State next(Transition transition)
                {
                    return STARTED;
                }
            },
    STARTED
            {
                @Override
                public State next(Transition transition)
                {
                    return DONE;
                }
            },
    DONE
            {
                @Override
                public State next(Transition transition)
                {
                    return ARCHIVED;
                }
            },
    ARCHIVED
            {
                @Override
                public State next(Transition transition)
                {
                    return ARCHIVED;
                }
            };

    public abstract State next(Transition transition);
}
