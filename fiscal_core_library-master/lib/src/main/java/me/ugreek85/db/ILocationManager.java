package me.ugreek85.db;

public interface ILocationManager<LocationType> {

    // Data Records

    LocationType getLocationRoot();
    LocationType getRegistrarStateLocationRoot(Long registrarId);
    LocationType getRegistrarInfoLocationRoot(Long registrarId);
    LocationType getShiftInfoLocationRoot(Long registrarId, String shiftId);
    LocationType getDocumentLocationRoot(Long registrarId, String shiftId);

    // Index Records

    LocationType getShiftDocumentIndexLocationRoot(Long registrarId, String shiftId);
    LocationType getShiftTimeIndexLocationRoot(Long registrarId);
    LocationType getLastShiftIndexLocationRoot(Long registrarId);
    LocationType getDocumentLocalNumberIndexLocationRoot(Long registrarId);
    LocationType getDocumentFiscalNumberIndexLocationRoot(Long registrarId);
    LocationType getDocumentTimeIndexLocationRoot(Long registrarId);
    LocationType getLastDocumentIndexLocationRoot(Long registrarId);
    LocationType getOfflineDocumentIndexLocationRoot(Long registrarId);
    LocationType getSentOfflineDocumentIndexLocationRoot(Long registrarId);
    LocationType getQueuedOfflineDocumentIndexLocationRoot(Long registrarId);
}
