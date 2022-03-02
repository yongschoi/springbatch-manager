package yongs.temp.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStepExecution is a Querydsl query type for StepExecution
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStepExecution extends EntityPathBase<StepExecution> {

    private static final long serialVersionUID = -1424682473L;

    public static final QStepExecution stepExecution = new QStepExecution("stepExecution");

    public final NumberPath<Long> commitCount = createNumber("commitCount", Long.class);

    public final DateTimePath<java.time.LocalDateTime> etime = createDateTime("etime", java.time.LocalDateTime.class);

    public final NumberPath<Long> executionId = createNumber("executionId", Long.class);

    public final StringPath exitCode = createString("exitCode");

    public final StringPath exitMessage = createString("exitMessage");

    public final NumberPath<Long> filterCount = createNumber("filterCount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> readCount = createNumber("readCount", Long.class);

    public final NumberPath<Long> rollbackCount = createNumber("rollbackCount", Long.class);

    public final StringPath status = createString("status");

    public final DateTimePath<java.time.LocalDateTime> stime = createDateTime("stime", java.time.LocalDateTime.class);

    public final NumberPath<Long> writeCount = createNumber("writeCount", Long.class);

    public QStepExecution(String variable) {
        super(StepExecution.class, forVariable(variable));
    }

    public QStepExecution(Path<? extends StepExecution> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStepExecution(PathMetadata metadata) {
        super(StepExecution.class, metadata);
    }

}

