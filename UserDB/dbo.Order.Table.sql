USE [UserDB]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2022/4/26 21:23:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[OrderId] [int] NOT NULL,
	[CutomerId] [int] NOT NULL,
	[PaymentId] [int] NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[Address1] [nvarchar](300) NOT NULL,
	[Address2] [nvarchar](300) NULL,
	[city] [nvarchar](100) NULL,
	[State] [nvarchar](100) NULL,
	[PostalCode] [nvarchar](10) NULL,
	[Country] [nvarchar](50) NULL,
	[Phone] [nvarchar](20) NOT NULL,
	[Notes] [nvarchar](max) NULL,
	[OrderTotal] [numeric](18, 2) NOT NULL,
 CONSTRAINT [Order_pk] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [Order_Payment_PatmentId_fk] FOREIGN KEY([PaymentId])
REFERENCES [dbo].[Payment] ([PatmentId])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [Order_Payment_PatmentId_fk]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [Order_usertable_id_fk] FOREIGN KEY([CutomerId])
REFERENCES [dbo].[usertable] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [Order_usertable_id_fk]
GO
