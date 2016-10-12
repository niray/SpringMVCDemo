//package com.niray.dao;
//
//import com.niray.model.UserEntity;
//import com.niray.redis.RedisGeneratorDao;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.stereotype.Repository;
//
//import static java.nio.file.Paths.get;
//
///**
// * Created by Mac on 16/10/12.
// */
//@Repository(value = "memberDao")
//public class MemberDaoImpl extends RedisGeneratorDao<String, UserEntity> implements IUserDao {
//
//    /**
//     * 新增
//     *
//     * @param user
//     * @return boolean
//     */
//    public boolean insertUser(UserEntity user) {
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection)
//                    throws DataAccessException {
//                RedisSerializer<String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize(user.getNickname());
//                byte[] name = serializer.serialize(user.getPassword());
//                return connection.setNX(key, name);
//            }
//        });
//        return result;
//    }
//
//    @Override
//    public void deleteUser(String user_id) {
//        redisTemplate.delete(user_id);
//    }
//
//    // R
//    public UserEntity searchUser(String user_id) {
//        UserEntity user = redisTemplate.execute(new RedisCallback<UserEntity>() {
//            @Override
//            public UserEntity doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                RedisSerializer<String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize(user_id);
//                byte[] value = redisConnection.get(key);
//                if (value == null) {
//                    return null;
//                } else {
//                    UserEntity user = new UserEntity();
//                    String name = serializer.deserialize(value);
//                    user.setNickname(name);
//                    user.setPassword(name);
//                    return user;
//                }
//            }
//        });
//        return user;
//    }
//
//    @Override
//    public boolean updateUser(UserEntity user) {
//        String key = String.valueOf(user.getId());
//        if (get(key) == null) {
//            throw new NullPointerException("数据不存在, key = " + key);
//        }
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            @Override
//            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                RedisSerializer<String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize(String.valueOf(user.getId()));
//                byte[] name = serializer.serialize(user.getNickname());
//                redisConnection.set(key, name);
//                return true;
//            }
//        });
//        return result;
//    }
//
//}
