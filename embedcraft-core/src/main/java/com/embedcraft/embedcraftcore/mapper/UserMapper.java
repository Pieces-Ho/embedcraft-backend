package com.embedcraft.embedcraftcore.mapper;

import com.embedcraft.embedcraftcore.entity.UserEntity;
import org.apache.ibatis.annotations.*;

/**
 * Mapper interface for executing SQL operations on the User entity.
 */
@Mapper
public interface UserMapper {

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return a UserEntity if a user with the specified ID exists; null otherwise
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    UserEntity selectUserById(@Param("id") int id);

    /**
     * Retrieves a user by their account name.
     *
     * @param account the account name of the user to retrieve
     * @return a UserEntity if a user with the specified account name exists; null otherwise
     */
    @Select("SELECT * FROM user WHERE account = #{account}")
    UserEntity selectUserByAccount(@Param("account") String account);

    /**
     * Retrieves a user by their account name and password.
     *
     * @param account  the account name of the user
     * @param password the password of the user
     * @return a UserEntity if a user with the specified account name and password exists; null otherwise
     */
    @Select("SELECT * FROM user WHERE account = #{account} AND password = #{password}")
    UserEntity selectUserByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * Inserts a new user into the database.
     * The user's ID is auto-generated by the database and populated back into the passed UserEntity object.
     *
     * @param userEntity the UserEntity object containing the data of the user to add
     * @return the number of rows affected by the insert operation
     */
    @Insert("INSERT INTO user(account, password) VALUES(#{account}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(UserEntity userEntity);

}
