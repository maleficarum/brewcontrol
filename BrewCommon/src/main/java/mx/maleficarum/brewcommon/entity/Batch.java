package mx.maleficarum.brewcommon.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import javax.persistence.EnumType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

import mx.maleficarum.brewcommon.entity.utils.BatchStatus;


/**
 * Batch data object
 * 
 * @author Oscar Hernandez [ o at maleficarum dot mx ] 
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_generator")
    @SequenceGenerator(name = "batch_generator", sequenceName = "batch_seq", allocationSize = 1)    
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "style", nullable = false, length = 50)
    private String style;

    @Column(name = "size_liters", nullable = false, precision = 6, scale = 2)
    private BigDecimal sizeLiters;

    @Column(name = "original_gravity", precision = 4, scale = 3)
    private BigDecimal originalGravity;

    @Column(name = "final_gravity", precision = 4, scale = 3)
    private BigDecimal finalGravity;

    @Column(name = "abv", precision = 3, scale = 1)
    private BigDecimal abv;

    @Column(name = "brew_date", nullable = false)
    private LocalDate brewDate;

    @Column(name = "fermentation_start_date")
    private LocalDate fermentationStartDate;

    @Column(name = "bottling_date")
    private LocalDate bottlingDate;

    @Column(name = "yeast_strain", length = 50)
    private String yeastStrain;

    @Column(name = "fermentation_temperature_c", precision = 4, scale = 1)
    private BigDecimal fermentationTemperatureC;

    @Column(name = "notes")
    private String notes;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private BatchStatus status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // PrePersist and PreUpdate hooks for timestamps
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}