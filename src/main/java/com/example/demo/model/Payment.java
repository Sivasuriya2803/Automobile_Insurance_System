package com.example.demo.model;

	import jakarta.persistence.*;
	import lombok.*;

	import java.math.BigDecimal;
	import java.time.LocalDateTime;

	@Entity
	@Table(name = "payment")
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Payment {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int paymentId;
	
		    @ManyToOne
		    @JoinColumn(name = "policy_id", nullable = false)
		    private Policy policy;
	
		    @ManyToOne
		    @JoinColumn(name = "user_id", nullable = false)
		    private User user;
	
		    private BigDecimal amount;
	
		    private LocalDateTime paymentDate = LocalDateTime.now();
	
		    @Enumerated(EnumType.STRING)
		    private PaymentStatus status;
	}


