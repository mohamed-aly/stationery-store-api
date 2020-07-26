package stationery.store.bundle.admin;


import stationery.store.bundle.abstractAndInterfaces.CrudService;

public interface AdminService extends CrudService<Admin, Long> {
    Admin addNewAdmin(final Admin admin);

}
