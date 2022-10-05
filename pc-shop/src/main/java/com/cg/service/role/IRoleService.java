package com.cg.service.role;

import antlr.collections.List;
import com.cg.model.Role;
import com.cg.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role getById(Long id);

    Role findByName(String name);
}
