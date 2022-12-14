package com.cg.service.user;

import com.cg.model.User;
import com.cg.model.dto.UserDTO;
import com.cg.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getById(Long id);

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);

    List<UserDTO> findAllUserDTO();

    List<UserDTO> findAllAdminDTO(Long id);

    Optional<User> findByIdAndDeletedFalse(Long id);

    void blockUser(Long id);

    void unblockUser(Long id);

    boolean existsByUsernameAndIdIsNot(String username, Long id);


}
