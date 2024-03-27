package com.project.dev.repositories;

import com.project.dev.UserDetailsProjection;
import com.project.dev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = """
			SELECT sers.email AS username, users.password, roles.id AS roleId, roles.authority
			FROM users
			INNER JOIN user_role ON users.id = user_role.user_id
			INNER JOIN roles ON roles.id = user_role.role_id
			WHERE users.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

	Optional<User> findByEmail(String email);
}
