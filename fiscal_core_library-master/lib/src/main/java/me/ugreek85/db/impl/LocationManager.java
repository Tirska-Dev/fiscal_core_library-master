package me.ugreek85.db.impl;

import me.ugreek85.db.ILocationManager;

import java.io.File;

public class LocationManager implements ILocationManager<File> {

    private File rootLocation;

    public LocationManager(File rootLocation) {
        this.rootLocation = rootLocation;
    }

    private File getRegistrarLocation(Long registrarId){
        return new File(rootLocation, registrarId.toString());
    }

    private File getIndexLocation(Long registrarId, String indexName){
        return new File(
                new File(getRegistrarLocation(registrarId), "index"),
                indexName);
    }

    @Override
    public File getLocationRoot() {
        return rootLocation;
    }

    @Override
    public File getRegistrarStateLocationRoot(Long registrarId) {
        return getRegistrarLocation(registrarId);
    }

    @Override
    public File getRegistrarInfoLocationRoot(Long registrarId) {
        return getRegistrarLocation(registrarId);
    }

    @Override
    public File getShiftInfoLocationRoot(Long registrarId, String shiftId) {
        return new File(getRegistrarLocation(registrarId), shiftId);
    }

    @Override
    public File getDocumentLocationRoot(Long registrarId, String shiftId) {
        return getShiftInfoLocationRoot(registrarId, shiftId);
    }

    @Override
    public File getShiftDocumentIndexLocationRoot(Long registrarId, String shiftId) {
        return new File(getIndexLocation(registrarId, "sd"), shiftId); //shift-document
    }

    @Override
    public File getShiftTimeIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "st"); //shift-time
    }

    @Override
    public File getLastShiftIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "ls"); //last-shift
    }

    @Override
    public File getDocumentLocalNumberIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "lnd"); //local-number-document
    }

    @Override
    public File getDocumentFiscalNumberIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "fnd"); //fiscal-number-document"
    }

    @Override
    public File getDocumentTimeIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "td"); //time-document
    }

    @Override
    public File getLastDocumentIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "ld"); //last-document
    }

    @Override
    public File getOfflineDocumentIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "od"); //offline-documents
    }

    @Override
    public File getSentOfflineDocumentIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "sod"); //sent-offline-documents
    }

    @Override
    public File getQueuedOfflineDocumentIndexLocationRoot(Long registrarId) {
        return getIndexLocation(registrarId, "qod"); //queued-offline-documents
    }

}
