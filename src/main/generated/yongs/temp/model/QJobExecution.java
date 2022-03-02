package yongs.temp.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobExecution is a Querydsl query type for JobExecution
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobExecution extends EntityPathBase<JobExecution> {

    private static final long serialVersionUID = 954544656L;

    public static final QJobExecution jobExecution = new QJobExecution("jobExecution");

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final StringPath exitCode = createString("exitCode");

    public final StringPath exitMessage = createString("exitMessage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> instanceId = createNumber("instanceId", Long.class);

    public final StringPath jobConfigurationLocation = createString("jobConfigurationLocation");

    public final DateTimePath<java.time.LocalDateTime> lastUpdated = createDateTime("lastUpdated", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final StringPath status = createString("status");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QJobExecution(String variable) {
        super(JobExecution.class, forVariable(variable));
    }

    public QJobExecution(Path<? extends JobExecution> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobExecution(PathMetadata metadata) {
        super(JobExecution.class, metadata);
    }

}

