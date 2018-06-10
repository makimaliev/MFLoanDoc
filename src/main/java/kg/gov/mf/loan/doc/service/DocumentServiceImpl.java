package kg.gov.mf.loan.doc.service;

import com.sun.jmx.snmp.tasks.TaskServer;
import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.doc.dao.DocumentDao;
import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.DocumentStatus;
import kg.gov.mf.loan.doc.model.Transition;
import kg.gov.mf.loan.task.model.Task;
import kg.gov.mf.loan.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl extends GenericServiceImpl<Document> implements DocumentService
{
    private DocumentDao dao;
    private DocumentStatusService documentStatusService;
    private TaskService taskService;

    @Autowired
    public DocumentServiceImpl(DocumentDao dao, DocumentStatusService documentStatusService, TaskService taskService) {
        this.dao = dao;
        this.documentStatusService = documentStatusService;
        this.taskService = taskService;
    }

    @Override
    public List<Document> getDocuments(String documentType, Long userId) {
        return dao.getDocuments(documentType, userId);
    }

    @Override
    public List getArchivedDocuments(Long userId) {
        return dao.getArchivedDocuments(userId);
    }

    @Override
    public List getInvolvedDocuments(Long userId) {
        return dao.getInvolvedDocuments(userId);
    }

    @Override
    public Document create(Document document, String action) {

        document = init(document, action);
        document.setSenderStatus(document.getGeneralStatus());
        return dao.create(document);
    }

    @Override
    public Document request(Document document, String action) {

        document = init(document, action);
        for(final Staff s : document.getSenderResponsible().getStaff()) {
            taskService.add(addTask(document, s));
        }

        return null;
    }

    @Override
    public Document approve(Document document, String action) {
        return null;
    }

    @Override
    public Document reject(Document document, String action) {
        return null;
    }

    @Override
    public Document register(Document document, String action) {
        return null;
    }

    @Override
    public Document accept(Document document, String action) {
        return null;
    }

    @Override
    public Document send(Document document, String action) {
        return null;
    }

    @Override
    public Document start(Document document, String action) {
        return null;
    }

    @Override
    public Document finish(Document document, String action) {
        return null;
    }

    private DispatchData setDispatchData(String internalName, Document document) {

        DispatchData dispatchData = new DispatchData();
        dispatchData.setDescription(document.getDocumentState().stringValue());
        dispatchData.setDispatchBy(userService.findById(document.getOwner()));
        dispatchData.setDispatchTo(userService.findById(1L));
        dispatchData.setDispatchInitTime(new Date());
        dispatchData.setDispatchType(document.getDocumentState());

        dispatchData.setParent(true);

        return dispatchData;
    }
    private Document init(Document document, String action) {

        DispatchData dispatchData = setDispatchData(action, document);
        DocumentStatus documentStatus = documentStatusService.getByInternalName(action);

        document.setGeneralStatus(documentStatus);
        document.setDocumentState(document.getDocumentState().next(Transition.valueOf(action.toUpperCase())));
        document.getSenderDispatchData().add(dispatchData);

        return document;
    }
    private Task addTask(Document document, Object responsible) {

        Integer responsibleType = document.getReceiverResponsible().getResponsibleType();
        /*
        Task task = new Task();
        task.setSummary("Документ : ");
        task.setDescription(document.getDescription());
        task.setResolutionSummary(document.getDescription());
        task.setProgress(document.getGeneralStatus().getInternalName().toUpperCase());
        task.setIdentifiedByUserId(getUser().getId());
        task.setModifiedByUserId(getUser().getId());
        task.setObjectType("/doc/edit/" + document.getId());
        task.setObjectId(document.getId());
        task.setTargetResolutionDate(document.getReceiverDueDate() != null ? document.getReceiverDueDate() : new Date());
        task.setCreatedBy(getUser());

        if(responsibleType == 1)
        {
            task.setAssignedToUserId(getUser((Staff)responsible).getId());
        }
        else if(responsibleType == 2)
        {
            task.setAssignedToUserId(getUser((Department)responsible).getId());
        }
        else if(responsibleType == 3)
        {
            task.setAssignedToUserId(getUser((Organization) responsible).getId());
        }
        else
        {
            task.setAssignedToUserId(getUser((Person)responsible).getId());
        }
        */
        return null;
    }
}
