package com.lti.mod.searchservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.mod.searchservice.dto.CourseIndexDTO;
import com.lti.mod.searchservice.dto.CourseUpdateIndexDTO;
import com.lti.mod.searchservice.dto.TrainingEnrollmentDTO;
import com.lti.mod.searchservice.exception.IndexFailed;

@Service
public class SearchService {
	
	private static final String TYPE = "_doc";
	private static final String INDEX_NAME = "courses";
	@Autowired
	JestClient jestClient;

	public void createUpdateIndex(CourseIndexDTO course) throws Exception  {
			
			JestResult jestResult = 
					jestClient.execute(new Index.Builder(course).index(INDEX_NAME).type(TYPE).build());
			if (jestResult.isSucceeded()) {
			    System.out.println(jestResult);
			}
			else {
			    System.out.println("Error: " + jestResult.getErrorMessage());
			    throw new IndexFailed(jestResult.getErrorMessage());
			}

	}
	
	public List<CourseIndexDTO> getAllCourses() throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
//		searchSourceBuilder.query(QueryBuilders.matchQuery("user", "kimchy"));
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		Search search = new Search.Builder(searchSourceBuilder.toString())
		                                .addIndex(INDEX_NAME)
		                                .addType(TYPE)
		                                .build();

		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public List<CourseIndexDTO> coursesByMentor() throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
//		searchSourceBuilder.query(QueryBuilders.matchQuery("user", "kimchy"));
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		Search search = new Search.Builder(searchSourceBuilder.toString())
		                                .addIndex(INDEX_NAME)
		                                .addType(TYPE)
		                                .build();

		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public List<CourseIndexDTO> allPendingApprovalCourses(String mentorUsername) throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		boolQuery.must(QueryBuilders.matchPhraseQuery("userName", mentorUsername));
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.courseApprovalStatus.keyword", "PENDING"));
//		NestedQueryBuilder nestedQueryBuilder = QueryBuilders
//	            .nestedQuery(
//	                    "trainees",
//	                    QueryBuilders.termQuery("trainees.courseApprovalStatus","PENDING"), ScoreMode.None);
//		boolQuery.must(nestedQueryBuilder);
		searchSourceBuilder.query(boolQuery);
		Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_NAME)
                .addType(TYPE)
                .build();
		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public List<CourseIndexDTO> getAllTrainees(String mentorUsername) throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		boolQuery.must(QueryBuilders.matchPhraseQuery("userName", mentorUsername));
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.courseApprovalStatus.keyword", "APPROVED"));
		searchSourceBuilder.query(boolQuery);
		Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_NAME)
                .addType(TYPE)
                .build();
		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	
	public List<CourseIndexDTO> studentPendingApprovalCourses(String traineeUsername ) throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//		boolQuery.must(QueryBuilders.matchPhraseQuery("userName", "kavya"));
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.userName.keyword", traineeUsername));
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.courseApprovalStatus.keyword", "PENDING"));
		searchSourceBuilder.query(boolQuery);
		Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_NAME)
                .addType(TYPE)
                .build();
		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	
	public List<CourseIndexDTO> studentCurrentCourses(String traineeUsername ) throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.userName.keyword", traineeUsername));
		boolQuery.must(QueryBuilders.matchPhraseQuery("trainees.courseApprovalStatus.keyword", "APPROVED"));
		searchSourceBuilder.query(boolQuery);
		Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_NAME)
                .addType(TYPE)
                .build();
		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public List<CourseIndexDTO> studentNewCourses(String traineeUsername) throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//		boolQuery.mustNot(QueryBuilders.matchPhraseQuery("userName.keyword", traineeUsername));
		boolQuery.mustNot(QueryBuilders.matchPhraseQuery("trainees.userName.keyword", traineeUsername));
//		boolQuery.mustNot(QueryBuilders.matchPhraseQuery("courseStatus.keyword", traineeUsername));
		/*
		 * boolQuery.mustNot(QueryBuilders.matchPhraseQuery(
		 * "trainees.courseApprovalStatus.keyword", "PENDING"));
		 * boolQuery.mustNot(QueryBuilders.matchPhraseQuery(
		 * "trainees.courseApprovalStatus.keyword", "APPROVED"));
		 * boolQuery.mustNot(QueryBuilders.matchPhraseQuery(
		 * "trainees.courseApprovalStatus.keyword", "REJECTED"));
		 */
		searchSourceBuilder.query(boolQuery);
		Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX_NAME)
                .addType(TYPE)
                .build();
		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public void updateTraineeDetails(CourseUpdateIndexDTO course) throws Exception  {
		
		CourseIndexDTO oldCourse = getCourseById(course.getCourseId());
		
		List<TrainingEnrollmentDTO> trainees = oldCourse.getTrainees();
		List<TrainingEnrollmentDTO> newTrainees = new ArrayList<TrainingEnrollmentDTO>();
		if(trainees!=null && newTrainees.size() > 0) {
			
			for(TrainingEnrollmentDTO t : trainees) {
				if( t.getId()== course.getTrainee().getId()) {
					newTrainees.add(course.getTrainee() );
				}else {
					newTrainees.add(t);
				}
			}
//			trainees=trainees.stream()
//					.filter(t -> t.getId()== course.getTrainee().getId())
//					.map(oldRecord -> course.getTrainee() )
//					.collect(Collectors.toList());
			
			System.out.print(newTrainees);
			//trainees.add(course.getTrainee());
		}else {
			newTrainees.add(course.getTrainee());
		}
		oldCourse.setTrainees(newTrainees);
		
		createUpdateIndex(oldCourse);

	}
	
	
	
	public CourseIndexDTO getCourseById(String id) throws Exception  {
		Get get = new Get.Builder(INDEX_NAME, id).type(TYPE).build();

		JestResult result = jestClient.execute(get);

		return result.getSourceAsObject(CourseIndexDTO.class);
	}
	
	
	public void createIndexSetup(String corename) throws IOException {
		JestResult jestResult = 
		jestClient.execute(new CreateIndex.Builder(corename).build());
		if (jestResult.isSucceeded()) {
		    System.out.println("Success!");
		}
		else {
		    System.out.println("Error: " + jestResult.getErrorMessage());
		    throw new IndexFailed(jestResult.getErrorMessage());
		}

	}
	
	public void deleteIndex(String id) throws IOException{
		JestResult jestResult = jestClient.execute(new Delete.Builder(id).index(INDEX_NAME).type(TYPE).build());
		 System.out.println(jestResult);
		if (jestResult.isSucceeded()) {
		    System.out.println("Success!");
		}
		else {
			 throw new IndexFailed(jestResult.getErrorMessage());
		}
	}

}
