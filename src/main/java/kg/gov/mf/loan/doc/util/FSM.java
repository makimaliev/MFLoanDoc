package kg.gov.mf.loan.doc.util;

import static kg.gov.mf.loan.doc.util.FSM.Transition.*;

public class FSM {

    public enum State
    {
        NEW
        {
            @Override public State next()
            {
                return CREATED;
            }
        },
        CREATED
        {
            @Override public State next(Transition transition)
            {
                if (transition == APPROVE)
                {
                    return APPROVED;
                }
                else if (transition == REJECT)
                {
                    return REJECTED;
                }
                else
                {
                    return PENDING;
                }
            }
        },
        APPROVED
        {
            @Override public State next(Transition transition)
            {
                return (transition == ACCEPT) ? ACCEPTED : PENDING;
            }
        },
        REJECTED
        {
            @Override public State next()
            {
                return DONE;
            }
        },
        ACCEPTED
        {
            @Override public State next()
            {
                return STARTED;
            }
        },
        STARTED
        {
            @Override public State next()
            {
                return DONE;
            }
        },
        DONE,
        PENDING;

        public State next(Transition transition)
        {
            return null;
        }
        public State next()
        {
            return null;
        }
    }

    public enum Transition
    {
        CREATE,
        APPROVE,
        REJECT,
        ACCEPT,
        START,
        DONE
    }
}
