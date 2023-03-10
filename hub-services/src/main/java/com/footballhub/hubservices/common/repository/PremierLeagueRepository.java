package com.footballhub.hubservices.common.repository;

import com.footballhub.hubservices.common.models.PremierLeagueModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PremierLeagueRepository extends MongoRepository<PremierLeagueModel, ObjectId> {
}
